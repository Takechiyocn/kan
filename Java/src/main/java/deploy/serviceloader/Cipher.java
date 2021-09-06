package deploy.serviceloader;

/**
 * 希望接口提供哪些方法
 */
public interface Cipher
{
   byte[] encrypt(byte[] source, byte[] key);
   byte[] decrypt(byte[] source, byte[] key);
   int strength();
}