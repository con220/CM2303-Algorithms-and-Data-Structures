import java.util.List;
import java.util.ArrayList;

public class HashTable {
  public HashTable(int numberOfKeys, int[] hashedKeys) {
    outerTable = new List[numberOfKeys];
    for(i=0; i<numberOfKeys; i++) {
      outerTable[i] = new ArrayList<String>();
    }


  }

  protected static int universalHash(int key, int a, int b, int p, int m) {
    /*  Chosen hash function from H (universal class of hash functions)
      input: rnd int a, rnd int b, prime p, size of table m, key to be hashed
      output: hash value for key  */
    return ((a*key + b) % p) % m;
  }

  public insert (String k, String v) {
    return false;

  }

  public delete (String k) {
    return false;

  }

  public locate (String k) {
    return null;

  }

  public printAll (String k) {
    return null;

  }
}