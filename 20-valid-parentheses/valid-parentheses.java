class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();

        for(char i: s.toCharArray()){
            if(i == '(' || i == '[' || i == '{') st.push(i);

            if(i == ')' || i == ']' || i == '}'){

                if(st.empty()) return false;

                if(st.peek() == '(' && i == ')') st.pop();
                else if(st.peek() == '{' && i == '}') st.pop();
                else if(st.peek() == '[' && i == ']') st.pop();
                else return false;

            }
        }

        return st.empty();
    }
}