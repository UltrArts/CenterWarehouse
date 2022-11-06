package Model.Rules;
public interface Validation {
    public boolean minSize(String text, int size);
    public boolean maxSize(String text, int size);
    public boolean isEqual(String text1, String text2);
    public boolean minMaxSize(String text, int minSize, int maxSize);
    public boolean isNull(String text);
}
