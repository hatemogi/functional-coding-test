val 삼사오 = List(3, 4, 5)

// O(1)

삼사오.isEmpty
삼사오.head
삼사오.tail

2 :: 삼사오
// 삼사오.prepended(2)
1 :: 2 :: 삼사오

3 :: 4 :: 5 :: Nil == 삼사오
Nil.isEmpty

// O(n)

(2 :: 삼사오).size
삼사오(0)  // 삼사오.head
삼사오(2)
//삼사오(3)

(삼사오).contains(2)
삼사오.indexOf(6)
