​
if(countMap.get(tempCharEnd) == 0){
count--;
}
}
​
while (count == 0) {
if(maxLen > end - start + 1) {
maxLen =  end - start + 1;
maxStart = start;
maxEnd = end + 1;
}
char tempCharStart = s.charAt(start);
if (countMap.containsKey(tempCharStart)) {
countMap.put(tempCharStart, countMap.get(tempCharStart) + 1);
if (countMap.get(tempCharStart) > 0) {
count++;
}
}
start++;
}
end++;
}
System.out.println(maxLen);
System.out.println("Start Index : " + maxStart +" End Index :" + maxEnd + ": "+ s.substring(maxStart,maxEnd));
return s.substring(maxStart,maxEnd);
}