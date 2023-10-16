import java.io.Serializable;

public class Block implements Serializable {

    private String Data;

    private byte[] PreviousBlockHash;

    public Block(byte[] PreviousBlockHash) {
        this.PreviousBlockHash = PreviousBlockHash;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public byte[] getPreviousBlockHash() {
        return PreviousBlockHash;
    }

    public void setPreviousBlockHash(byte[] PreviousBlockHash) {
        this.PreviousBlockHash = PreviousBlockHash;
    }

}
