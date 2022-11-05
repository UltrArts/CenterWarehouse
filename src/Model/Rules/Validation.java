package Model.Rules;
public interface Validation {
    public boolean validate(String text, int size, ValidationActionType type);
    public boolean validate(String text, int minSize, int maxSize);
    public boolean validate(String text1, String text2);
    public boolean validate(Object o);
}
