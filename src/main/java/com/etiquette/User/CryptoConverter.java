package com.etiquette.User;


import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class CryptoConverter implements AttributeConverter<String, String> {
 
 // Secrete Key for encryption
 final String SECRET_KEY = "mkAveKvwK5PSa3a5";
 // Encryption algorithm
 final String ENC = "AES";
 final String ALGORITHM = "AES/ECB/PKCS5Padding";
 
 private final Logger logger = LoggerFactory.getLogger(getClass());

 @Override
 public String convertToDatabaseColumn(String attribute) {
  // Encode data to store into database
  logger.info("Convert Application data to Database: {}", attribute);
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
  logger.info("Convert Database to Application data: {}", dbData);
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