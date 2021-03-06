
import java.io.*;

public class Scheduling{
	public static BufferedReader br;
	static int p;
	static int pid[];
	static int pri[];
	static int at[];
	static int bt[];
	static int ct[];
	static int tat[];
	static int wt[];
	static int k[];
	static int i;
	private static float avg;

//fcfs algorithm
	public static void fcfs(int num) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Arrival Time for Each Process: ");
			for(i=0;i<num;i++)
			{
				pid[i]=i+1;
				System.out.println("Enter AT for process "+(i+1));
				at[i] = Integer.parseInt(br.readLine());
			}			
			System.out.println("Enter the BURST Time : ");
			for(i=0;i<num;i++)
			{
				System.out.println("Enter BT for process "+(i+1));
				bt[i] = Integer.parseInt(br.readLine());				
			}
			//calculate completion time
			ct[0] = bt[0];
			for(i=1;i<num;i++)
			{
				//System.out.println("Completion Time for process "+(i+1));
				
				ct[i] = ct[i-1]+bt[i];
				//System.out.println("Completion Time for process "+(i+1)+" = "+ct[i]);
			}
			//calculate Turn Around Time
			
			for(i=0;i<num;i++)
			{	
				tat[i] = ct[i]-at[i];
				//System.out.println("Turn Around Time for process "+(i+1)+ " = "+tat[i]);
			}
			//calculate waiting time
			int sum = 0; 
			for(i=0;i<num;i++)
			{				
				wt[i] = tat[i]-bt[i];
				//System.out.println("Waiting Time for process "+(i+1)+ " = "+wt[i]);
				sum=sum+wt[i];
			}
			System.out.println("\nProcess\tAT\tBT\tCT\tTAT\tWT");
			for (int j=0;j<num;j++)
			{
			System.out.println(pid[j]+"\t"+at[j]+"\t"+bt[j]+"\t"+ct[j]+"\t"+tat[j]+"\t"+wt[j]);
			}
 
			avg=sum/num;
			System.out.println("\nAverage Waiting Time = "+ avg);
	}

//priority algorithm
	public static void priority(int num) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the BURST Time and Prority: ");
			for(i=0;i<num;i++)
			{
				System.out.println("\nFor process "+(i+1)+":");
				pid[i]=i+1;
				System.out.println("Enter Burst Time ");
				bt[i] = Integer.parseInt(br.readLine());
				System.out.println("Enter Priority ");
				pri[i] = Integer.parseInt(br.readLine());
			}
			//arranging in decending order
			int temp;
			for(i=0;i<(p-1);i++){
				for(int j=0;j<(p-i-1);j++){
					if(pri[j]<pri[j+1]){
					temp=pri[j];
					pri[j]=pri[j+1];
					pri[j+1]=temp;

					temp=pid[j];
					pid[j]=pid[j+1];
					pid[j+1]=temp;

					temp=bt[j];
					bt[j]=bt[j+1];
					bt[j+1]=temp;
					}
				}
			}	
			//calculate completion time
			ct[0] = bt[0];
			for(i=1;i<num;i++)
			{
				//System.out.println("Completion Time for process "+(i+1));
				
				ct[i] = ct[i-1]+bt[i];
				//System.out.println("Completion Time for process "+(i+1)+" = "+ct[i]);
			}
			//arranging in asending order
			
			for(i=0;i<(p-1);i++){
				for(int j=0;j<(p-i-1);j++){
					if(pid[j]>pid[j+1]){
					temp=pri[j];
					pri[j]=pri[j+1];
					pri[j+1]=temp;

					temp=pid[j];
					pid[j]=pid[j+1];
					pid[j+1]=temp;

					temp=bt[j];
					bt[j]=bt[j+1];
					bt[j+1]=temp;

					temp=ct[j];
					ct[j]=ct[j+1];
					ct[j+1]=temp;
					}
				}
			}
			//calculate Turn Around Time
			
			for(i=0;i<num;i++)
			{	
				tat[i] = ct[i]-at[i];
				//System.out.println("Turn Around Time for process "+(i+1)+ " = "+tat[i]);
			}
			//calculate waiting time
			int sum = 0; 
			for(i=0;i<num;i++)
			{				
				wt[i] = tat[i]-bt[i];
				//System.out.println("Waiting Time for process "+(i+1)+ " = "+wt[i]);
				sum=sum+wt[i];
			}
			System.out.println("\nProcess\tpriority\tBT\tCT\tTAT\tWT");
			for (int j=0;j<num;j++)
			{
			System.out.println(pid[j]+"\t"+pri[j]+"\t\t"+bt[j]+"\t"+ct[j]+"\t"+tat[j]+"\t"+wt[j]);
			}
 
			avg=sum/num;
			System.out.println("\nAverage Waiting Time = "+ avg);
	}

//sjf algorithm
	public static void sjf(int num) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		int st=0,tot=0;
		int f[] = new int[num];  // f means it is flag it checks process is completed or not
		
		System.out.println("Enter the Arrival Time for Each Process: ");
			for(i=0;i<num;i++)
			{
				pid[i]=i+1;
				System.out.println("Enter AT for process "+(i+1));
				at[i] = Integer.parseInt(br.readLine());
			}			
			System.out.println("Enter the BURST Time : ");
			for(i=0;i<num;i++)
			{
				System.out.println("Enter BT for process "+(i+1));
				bt[i] = Integer.parseInt(br.readLine());
				k[i]= bt[i];
	    			f[i]= 0;							
			}	
			//arranging according to burst time
			while(true){
			    	int min=99,c=num;
			    	if (tot==num)
			    		break;
			    	
			    	for ( i=0;i<num;i++)
			    	{
			    		if ((at[i]<=st) && (f[i]==0) && (k[i]<min))
			    		{	
			    			min=k[i];
			    			c=i;
			    		}
			    	}
			    	
			    	if (c==num)
			    		st++;
			    	else
			    	{
			    		k[c]--;
			    		st++;
			    		if (k[c]==0)
			    		{
			    			ct[c]= st;
			    			f[c]=1;
			    			tot++;
			    		}
			    	}
			    }
			int sum=0;
			 for(i=0;i<num;i++)
			 {
			    	tat[i] = ct[i] - at[i];
			    	wt[i] = tat[i] - bt[i];
			    	sum+= wt[i];
			    	//avgta+= ta[i];
			}
			System.out.println("\nProcess\tAT\tBT\tCT\tTAT\tWT");
			for (int j=0;j<num;j++)
			{
			System.out.println(pid[j]+"\t"+at[j]+"\t"+bt[j]+"\t"+ct[j]+"\t"+tat[j]+"\t"+wt[j]);
			}
 
			avg=sum/num;
			System.out.println("\nAverage Waiting Time = "+ avg);
	}

//round-robin algorithm
	public static void round(int num) throws IOException{
		int quantum=0;
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter burst time");
			for(int i=0;i<num;i++) { 
			pid[i]=i+1;
			System.out.print("\nP["+(i+1)+"]: "); 
			bt[i] = Integer.parseInt(br.readLine()); 
			k[i] = bt[i]; 
			wt[i]=0;
			} 
			System.out.print("\n\nEnter quantum: "); 
			quantum = Integer.parseInt(br.readLine());
			int rp = num;
			int i=0; 
			int time=0; 
			System.out.println("GianttChart for round robin algorithm =>");
			System.out.print("0"); 
			wt[0]=0; 
			while(rp!=0) { if(k[i]>quantum)
			 {
			   k[i]=k[i]-quantum;
			   System.out.print(" | P["+(i+1)+"] | ");
			   time+=quantum;
			   ct[i]=time;
			   tat[i]=ct[i];
			   System.out.print(time);
			   }
			 else if(k[i]<=quantum && k[i]>0)
			 {time+=k[i];
			ct[i]=time;
			tat[i]=ct[i];
			  k[i]=k[i]-k[i];
			  System.out.print(" | P["+(i+1)+"] | ");
			  rp--;
			System.out.print(time);
			 }
			 
			i++;
			if(i==num)
			{
			i=0;
			}
			 
			}
			 
			for(int j=0;j<num;j++)
				wt[j]=tat[j]-bt[j];
			System.out.println("\n\nProcess\tBT\tCT\tTAT\tWT");
			for (int j=0;j<num;j++)
			{
			System.out.println(pid[j]+"\t"+bt[j]+"\t"+ct[j]+"\t"+tat[j]+"\t"+wt[j]);
			}
 
			//avg=sum/num;
			//System.out.println("\nAverage Waiting Time = "+ avg);
	}

//main execution
	public static void main(String[] args) throws IOException
	{
		try
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the no of Processes: - ");
			
			p = Integer.parseInt(br.readLine());
				
			at = new int[p];
			bt = new int[p];
			ct = new int[p];
			tat = new int[p];
			wt = new int[p];
			pid = new int[p];
			pri = new int[p];
			k= new int[p];   // it is also stores brust time
			System.out.println("Scheduling Algorithms which are allow to appliy : - \n1.FCFS\n2.SJF\n3.Priority\n4.Round-Robin\n\nEnter your choice :-");
			
			 int choice= Integer.parseInt(br.readLine());

			switch(choice){
				case 1: System.out.println("\n******************You are selected FCFS******************");
					fcfs(p);
					break;
				case 2: System.out.println("\n******************You are selected SJF******************");
					sjf(p);
					break;
				case 3: System.out.println("\n******************You are selected Priority******************");
					priority(p);break;
				case 4: System.out.println("\n******************You are selected Round-Robin******************");
					round(p);
					break;
				default: System.out.println("\nInvalid choice");
					break;
			}
			
			
			
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}

}
