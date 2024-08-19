Pull Request Description: XML Validator Implementation Using Stack
Title: Implement determineXml Method Using Stack for XML Validation

Summary:
This pull request introduces the implementation of the determineXml method within the XMLValidator class. The method is designed to validate the structure of an XML string by using a stack to ensure proper nesting and closure of XML tags. The method returns true if the XML is well-formed, and false if it is not.

Details:

Method Implementation:

determineXml(String xml): This method validates an XML string by leveraging a stack of strings to track open tags. It processes the XML string character by character, identifying opening and closing tags:
When an opening tag (<tagname>) is encountered, the tag name is pushed onto the stack.
When a closing tag (</tagname>) is encountered, the method checks if it matches the tag name at the top of the stack. If it matches, the tag is popped from the stack.
If at any point the tags do not match or the stack operations indicate improper nesting, the method returns false.
After processing the entire string, if the stack is empty, the method returns true, indicating that the XML is well-formed.
Edge Cases Considered:

The method handles cases where the XML string is improperly formed, such as:
Mismatched opening and closing tags.
Closing tags without corresponding opening tags.
Unclosed tags.