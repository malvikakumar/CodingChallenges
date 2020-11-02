/* 
We’re going to tackle a problem we’ve run into: we need to make calls to a 3rd party API while respecting their rate limits.
You are working with a single rate-limited API that allows 100 requests per hour.
Please implement a function consumeRateLimit() that returns a boolean that represents if we can make another request; this function should encapsulate the logic of how many requests have been made so far. The function should return “false” if making the call would put you over the call limit for the past hour and “true” otherwise.
 */

import java.time.LocalTime;
import java.util.*;

 class RateLimit {
    public Queue<LocalTime> queue;
    
    public RateLimit() {
      queue = new LinkedList<LocalTime>();
    }
    public static void main(String[] args) {
      RateLimit r = new RateLimit();
      System.out.println(r.consumeRateLimit());
      System.out.println(r.consumeRateLimit());
      System.out.println(r.consumeRateLimit());
      System.out.println(r.consumeRateLimit());
      
    }
    
    public boolean consumeRateLimit() {
      LocalTime currentTime = java.time.LocalTime.now();
      
      // while(currentTime - queue.peek() > 60000) {
      //   queue.poll();
      // }
      
      boolean canSend = queue.size() < 3;
      if(canSend) {
        queue.offer(currentTime);
      }
      
      return canSend;
    }
  }