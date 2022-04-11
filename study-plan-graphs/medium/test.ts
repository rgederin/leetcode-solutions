let s = new Set();
let s2 = new Set();

s2.add("s1")
s2.add("s2")

s.add(s2.values());

console.log(s)

s2.clear();

console.log(s)