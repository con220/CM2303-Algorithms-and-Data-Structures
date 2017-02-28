class HashTable {
  public HashTable () {

  }

  private int hash (String k) {
    return 0;

  }

  public boolean add (String k, String v) {
    return false;

  }

  public boolean modify (String k, String v) {
    return false;

  }

  public boolean del (String k) {
    return false;

  }

  public String get (String k) {
    return null;

  }

  public void print_all () {
    return;

  }

  public static void main (String[] args) {
    HashTable h = new HashTable ();
    if (!h.add("First", "1")) {
      System.out.println ("Failed 1");
    }
    if (!h.add("Second", "2")) {
      System.out.println ("Failed 2");
    }
    h.modify ("Second", "22");
    h.print_all ();
    h.del ("First");
    if (!h.add("First", "3")) {
      System.out.println ("Failed 3");
    }
    h.print_all ();
    h.del ("Second");
    h.del ("Third");

  }
}