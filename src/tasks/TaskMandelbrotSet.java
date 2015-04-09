package tasks;
import api.Task;




public class TaskMandelbrotSet implements Task<Integer[][]>{
	private double lower_left_x = 0.0;
	private double lower_left_y = 0.0;
	private double edge_length = 0.0;
	private int n_pixels = 0;
	private int limit = 0;

	public TaskMandelbrotSet(double lx, double ly, double edgelength, int n_pixels, int limit){
		this.lower_left_x = lx;
		this.lower_left_y = ly;
		this.edge_length = edgelength;
		this.n_pixels = n_pixels;
		this.limit = limit;
	}

	@Override
	public Integer[][] execute() {
		// TODO Auto-generated method stub
		
		Integer[][] count = new Integer[n_pixels][n_pixels];
		double x,y,xtemp;
	    double sx=lower_left_x,sy=lower_left_y;
	    double step = (double)edge_length/n_pixels;
	    for (int i = 0; i <n_pixels; i++) {
	        for (int j = 0; j < n_pixels; j++) {
	            x=0;
	            y=0;
	            sx+=step;
	            int iteration =0;
	            while ( x*x + y*y < 4  &&  iteration < limit){
	                xtemp = x*x - y*y + sx;
	                y = 2*x*y + sy;
	                x = xtemp;
	                iteration++;
	            }
	            count[j][i]=iteration;
	        }
	        sx=lower_left_x;
	        sy+=step;
	    }
		return count;
	}
	

	
	
}
