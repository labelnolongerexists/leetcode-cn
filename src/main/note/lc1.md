## 思路

### 暴力法:
穷举所有2个数之和, 复杂度是n²

### 进阶的思考
* 改变定势思维, a+b=k可以变换为a=k-b
* 利用hash结构, 一遍迭代一遍将数字放入hash
* 设 targetNumber = k - 当前数, 如果这个targetNumber数在hash中存在, 直接返回当前数和targetNumber即可.
* 最后时间复杂度是o(n)

