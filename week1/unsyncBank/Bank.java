package unsyncBank;
class Bank
{  public Bank(int n, int initialBalance)
   {  accounts = new int[n];
      int i;
      for (i = 0; i < accounts.length; i++)
         accounts[i] = initialBalance;
      ntransacts = 0;
   }

   public void transfer(int from, int to, int amount)
   {  if (accounts[from] < amount) return;
      accounts[from] -= amount;

      // let the O/S run another thread 
      Thread.currentThread().yield();

      accounts[to] += amount;
      ntransacts++;
      if (ntransacts % NTEST == 0) test();
   }

   public void test()
   {  int sum = 0;

      for (int i = 0; i < accounts.length; i++)
         sum += accounts[i];

      System.out.println("Transactions:" + ntransacts
         + " Sum: " + sum);
   }

   public int size()
   {  return accounts.length;
   }

   public static final int NTEST = 10;
   private int[] accounts;
   private long ntransacts = 0;
}