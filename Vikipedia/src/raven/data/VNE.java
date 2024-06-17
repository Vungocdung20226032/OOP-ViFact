package raven.data;


import java.util.ArrayList;

 
public class VNE {

	protected String name;
        protected String sci_name;
        protected String date;
	protected String[] struct;
	protected String infect;
        protected String brief;
        protected int[] case_kill_survive;
        protected String image;
        protected String video;
	
	
	
	public VNE(String name,String[] struct,String infect, String s, String date, int[] ckv, String b, String i, String v) {
		super();
		this.name = name;
                this.sci_name = s;
                this.date = date;
		this.struct=struct;
		this.infect=infect;
                this.brief = b;
                this.case_kill_survive = ckv;
                this.image = i;
                this.video = v;
	
	}
	
	public String[] getStruct() {
		return this.struct;
		}
	public void showInfect() {
		System.out.println(this.getName()+": " );
        System.out.println("Infection: " + this.getInfect());
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

        public String getSciName() {
            return this.sci_name;
        }
        
        public String getDate() {
            return this.date;
        }


	public String getInfect() {
		return infect;
	}
        
        public String getBrief() {
                return this.brief;
        }

        public int[] getCase() {
            return this.case_kill_survive;
        }

	public void setInfect(String infect) {
		this.infect = infect;
	}

        public String getImage() {
            return this.image;
        }
        
        public String getVideo() {
            return this.video;
        }
}