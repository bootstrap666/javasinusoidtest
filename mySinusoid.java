package mySinusoid;


public class mySinusoid {

	private double Start, End, SamplingPeriod, Amplitude, Frequency, Phase;
	
	public mySinusoid() {
		
		Start = 0.0;
		End = 1.0;
		SamplingPeriod = 0.01;
		Amplitude = 1.0; 
		Frequency = 1; 
		Phase = 0.0;
	}
	
	public void set_Start(double start) {
		Start = start; 
	}
	public double read_Start() {
		return Start;
	}
	public void set_End(double end) {
		End = end;
	}
	public double read_end() {
		return End;
	}
	public void set_SamplingPeriod(double Ts) {
		SamplingPeriod = Ts;
	}
	public double read_SamplingPeriod() {
		return SamplingPeriod;
	}
	public void set_Amplitude(double A) {
		Amplitude = A;
	}
	public double get_Amplitude() {
		return Amplitude;
	}
	public void set_Frequency(double f) {
		Frequency = f;
	}
	public double get_Frequency() {
		return Frequency;
	}
	public void set_Phase(double theta) {
		Phase = theta;
	}
	public double get_Phase() {
		return Phase;
	}
	
	private double[] readx(){
		int N = (int) Math.ceil((End - Start)/SamplingPeriod);
		double[] x;
		double a;
		x = new double[N];
		int i = 0;
		for (a = Start;a < End;a+=SamplingPeriod) {
			x[i] = a;
			i++;
		}
		
		return x;
	}
	private double[] ready(double[] x){
		int N;
		double y[];
		N = x.length;
		y = new double[N];
		for (int i=0;i<N;i++)
			y[i] = Amplitude * Math.sin( 2.0*Math.PI*Frequency*x[i] + Phase);
		return y;
	}
	public void print() {
		double x[],y[];
		x = readx();
		y = ready(x);
		for (int i=0;i<x.length;i++)
			//System.out.println(  Double.toString(x[i]) +','+ Double.toString(y[i]) );
			System.out.println(  String.format("%.3f, %.3f", x[i],y[i]) );
		return;
	}
}
