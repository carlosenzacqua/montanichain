import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) {

        // creazione primo blocco
        Block block1 = new Block(null);
        block1.setData("Blocco1");

        // creazione del secondo blocco      
        Block block2 = new Block(hashBlock(block1));
        block2.setData("Blocco2");
    }

    /*
        Calculate md5 hash of a block
    */
    private static byte[] hashBlock(Block block) {
        byte[] hash = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            hash = md5.digest(serializeBlock(block));
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Hashing error");
        }
        return hash;
    }

    /*
        Serialize block
    */
    private static byte[] serializeBlock(Block block) {
        byte[] serializedBlock = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(block);
            out.flush();
            serializedBlock = bos.toByteArray();
        } catch (IOException e) {
            System.out.println("Serialization error");
        }
        return serializedBlock;
    }
}
