import javax.swing.text.html.HTML;
import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {


	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		Stack<HtmlTag> stack = new Stack<>();

		while (!tags.isEmpty()) {

			HtmlTag currentTag = tags.poll();


			if (currentTag.isSelfClosing()) {
				continue;

			}else if (currentTag.isOpenTag()) {
				stack.push(currentTag);
			} else {
				if (stack.isEmpty()) {
					return null;
				}

				HtmlTag openTag = stack.peek();

				if (currentTag.matches(openTag)) {
					stack.pop();
				} else {
					return stack;
				}

				if (tags.isEmpty()) {
					return stack;
				}
			}
		}
			return null; // this line is here only so this code will compile if you don't modify it

		}
	}




