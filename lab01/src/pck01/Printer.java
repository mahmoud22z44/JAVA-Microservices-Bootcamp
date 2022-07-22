package pck01;

public class Printer {
	public String part1;
	public String part2;
	public int visitors;
	
	public Printer() {
		part1 = "There will be ";
		part2 = " people for dinner.";
		visitors = 5;
		System.out.println(part1+visitors+part2);
	}
	
	public String toString() {
		return (part1+visitors+part2);
	}
	
/* question 2
 * ●	What happens when adding just visitors+2?
 * if i put in like this sentext (part1+visitors+2+part2)
 * that must to print "There will be 52 people for dinner."
 * ●	What is the right way of updating the print line?
 * i have to ways to updating the print line 
 * 1) put the visitors+2 in Parenthesis.
 * 2) add function that set value or add value to variable visitors.
	*/
}
