package xmlvalidatorlibrary;

import java.util.Stack;

public class SimpleXmlValidator {
    public static boolean determineXml(String xml)
    {
        Stack<String> stack = new Stack<>();

        int i = 0;
        while (i < xml.length()) {
            // Check for opening tag
            if (xml.startsWith("<", i) && !xml.startsWith("</", i)) {
                int closingBracketIndex = xml.indexOf(">", i);
                if (closingBracketIndex == -1) {
                    return false; // Invalid XML if no closing bracket
                }
                String tagName = xml.substring(i + 1, closingBracketIndex);
                stack.push(tagName);
                i = closingBracketIndex + 1;
            }
            // Check for closing tag
            else if (xml.startsWith("</", i)) {
                int closingBracketIndex = xml.indexOf(">", i);
                if (closingBracketIndex == -1) {
                    return false; // Invalid XML if no closing bracket
                }
                String tagName = xml.substring(i + 2, closingBracketIndex);
                if (stack.isEmpty() || !stack.pop().equals(tagName)) {
                    return false; // Mismatch or no matching opening tag
                }
                i = closingBracketIndex + 1;
            }
            // Move to the next character
            else {
                i++;
            }
        }
        // If the stack is empty, the XML is valid
        return stack.isEmpty();
    }
}
