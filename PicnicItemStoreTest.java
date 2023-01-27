public class PicnicItemStoreTest
{
    public void main()
    {
        PicnicItemStore store = new PicnicItemStore();
        store.put("a", "abiu");
        store.put("bl", "blackberry");
        store.put("bl", "blackcurrent");
        store.put("a", "apricot");
        random_test(store, "a");
        random_test(store, "b");
        random_test(store, "c");
        
        
    }
    
    public String random_test(PicnicItemStore store, String key)
    {
        return store.getRandomItem(key);
    }



}
