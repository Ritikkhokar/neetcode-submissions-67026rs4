class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        myMap1 = dict()
        myMap2 = dict()
        for i in s:
            if i in myMap1:
                myMap1[i] = myMap1[i]+1;
            else:
                myMap1[i] = 1;

        for i in t:
            if i in myMap2:
                myMap2[i] = myMap2[i]+1;
            else:
                myMap2[i] = 1;
        
        for key in myMap1:
            if key not in myMap2 or myMap1[key] !=  myMap2[key]:
                return False
        
        return True
