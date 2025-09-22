package com.etiquette.Encryption;


import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class CryptoConverter implements AttributeConverter<String, String> {
 
 // Secrete Key for encryption

 Dotenv dotenv = Dotenv.load();

 String secretKey = dotenv.get("SECRET_KEY_ENCRYPTION");
 String enc = dotenv.get("ENC");
 String algo = dotenv.get("ALGORITHM");
 
 final String SECRET_KEY = secretKey;
 
 // Encryption algorithm
 final String ENC = enc;
 final String ALGORITHM = algo;
 
 private final Logger logger = LoggerFactory.getLogger(getClass());

 @Override
 public String convertToDatabaseColumn(String attribute) {
  // Encode data to store into database
  String value = null;
  try {
   Key key = new SecretKeySpec(SECRET_KEY.getBytes(), ENC);
   Cipher c = Cipher.getInstance(ALGORITHM);
   c.init(Cipher.ENCRYPT_MODE, key);
   value = Base64.getEncoder().encodeToString(c.doFinal(attribute.getBytes()));
   
  } catch(Exception e) {
   logger.info("Failed to encode: "+ e.getMessage());
   e.printStackTrace();
  }
  return value;
 }

 @Override
 public String convertToEntityAttribute(String dbData) {
  // Decode data to use in Application
  String value = null;
  try {
   Key key = new SecretKeySpec(SECRET_KEY.getBytes(), ENC);
   Cipher c = Cipher.getInstance(ALGORITHM);
   c.init(Cipher.DECRYPT_MODE, key);
   value = new String(c.doFinal(Base64.getDecoder().decode(dbData)));
   
  } catch(Exception e) {
   logger.info("Failed to decode: "+ e.getMessage());
   e.printStackTrace();
  }
  return value;
 }
}