import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i){
            if (isLeft(s.charAt(i))) stack.push(s.charAt(i));
            else if (isRight(s.charAt(i)))
                if (stack.isEmpty()) return false;
                if(!isPairOf(s.charAt(i), stack.pop())) return false;
        }
        return stack.isEmpty();
    }
    public boolean isPairOf(char end, char start){
        if (start == '{' && end == '}') return true;
        if (start == '(' && end == ')') return true;
        if (start == '[' && end == ']') return true;
        return false;
    }
    public boolean isLeft(char c){
        return (c == '{' || c == '[' || c == '(');
    }
    public boolean isRight(char c){
        return (c == '}' || c == ']' || c == ')');
    }
}
