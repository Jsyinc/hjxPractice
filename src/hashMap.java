//import java.util.AbstractMap;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//public class hashMap<K, V> {
//
//
//    static final float DEFAULT_LOAD_FACTORY = 0.75f;
//    static final int DEFAULT_CAPACITY = 16;
//    float loadFactor;
//    float capaCity;
//
//    static class Node<K,V> implements Map.Entry<K,V>{
//        final int hash;
//        final K key;
//        V value;
//        Node<K,V> next;
//
//        Node(int hash,K key,V value,Node<K,V> next){
//            this.hash=hash;
//            this.key=key;
//            this.value=value;
//            this.next=next;
//        }
//
//        @Override
//        public final K getKey() {
//            return key;
//        }
//
//        @Override
//        public final V getValue() {
//            return value;
//        }
//
//        @Override
//        public final V setValue(V value) {
//            return null;
//        }
//    }
//
//    public hashMap(){
//        this.loadFactor = DEFAULT_LOAD_FACTORY;
//        this.capaCity = DEFAULT_CAPACITY;
//    }
//
//    public hashMap(int capacity){
//        this.capaCity = capacity;
//    }
//
//
//    public V get(Object key){
//        Node<K,V> e;
//        return
//        return V;
//    }
//
//}
