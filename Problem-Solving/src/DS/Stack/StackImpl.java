package DS.Stack;

public class StackImpl {

	static int top = -1;
	static int[]  stack = new int[1000];
	static int  min = stack[top];
	static int  max = stack[top] ;
	public int peek() {
	      return top;
	    }

	    public int pop() {
	      if(top != -1)
					top = top -1;
				
				return top;
	    }

	    public void push(Integer number) {			
				top = top + 1;
				stack[top] = number;
				if(top-1 == -1){
					min = stack[top];
					max = stack[top];
				}
				else{
					if(number < min)
						min = number;
					else if(number > max)
						max = number;
				}
					
	      
	    }

	    public int getMin() {      
	      return min;
	    }

	    public int getMax() {      
	      return max;
	    }
	
	
		public static void main(String[] args) {
		StackImpl stack = new StackImpl();
		stack.push(5);
	    stack.push(7);
	    stack.push(2);

	}	

}


