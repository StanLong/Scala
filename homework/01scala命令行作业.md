1. 对3先开方，再平方，然后再计算3与该值的差值。

   ```scala
   scala> scala.math.sqrt(3)
   val res0: Double = 1.7320508075688772
   
   scala> res0 * res0
   val res1: Double = 2.9999999999999996
   
   scala> 3 - res1
   val res2: Double = 4.440892098500626E-16
   ```

2. 用数字乘以字符串，观察效果

   ```scala
   scala> "scala" * 3
   val res3: String = scalascalascala
   ```

3. 使用max比较两个数的大小

   ```scala
   scala> 2 max 10 # 方式一
   val res4: Int = 10
   
   scala> 2.max(10) # 方式二
   val res5: Int = 10
   ```

4. 用BigInt计算2的1024次方

   ```scala
   scala> val num = BigInt(2) # 方式一
   val num: scala.math.BigInt = 2
   
   scala> num.pow(1024)
   val res6: scala.math.BigInt = 179769313486231590772930519078902473361797697894230657273430081157732675805500963132708477322407536021120113879871393357658789768814416622492847430639474124377767893424865485276302219601246094119453082952085005768838150682342462881473913110540827237163350510684586298239947245938479716304835356329624224137216
   
   scala> BigInt(2).pow(1024) # 方式二
   val res7: scala.math.BigInt = 179769313486231590772930519078902473361797697894230657273430081157732675805500963132708477322407536021120113879871393357658789768814416622492847430639474124377767893424865485276302219601246094119453082952085005768838150682342462881473913110540827237163350510684586298239947245938479716304835356329624224137216
   ```

5. 取Hello的首字符和尾字符

   ```scala
   # 取首字符
   scala> "Hello".take(1)
   val res8: String = H
   
   # 取尾字符
   scala> "Hello".reverse.take(1) # 方式一
   val res10: String = o
   
   scala> "Hello".takeRight(1) # 方式二
   val res12: String = o
   ```

6. 求Hello字符串长度

   ```scala
   scala> "Hello".length
   val res14: Int = 5
   ```

   