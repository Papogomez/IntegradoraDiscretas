package model;

public interface Interface <T, U>{
    public void insert(T key, U value) throws Exception;
    public U search(T key);
    public void deleteKey(T key);
}
