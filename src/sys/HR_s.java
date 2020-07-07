package sys;
import bean.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Formatter;
public class HR_s {
    private boolean firstOne=true;
    private Scanner input=new Scanner(System.in);
    Formatter formatter=new Formatter(System.out);
    ArrayList<Resume> resumes=new ArrayList<>();
    HR_s(){
        while(firstOne){
            System.out.println("欢迎进入浦发银行招聘网站！");
            System.out.println("添加简历请按0");
            System.out.println("删除简历请按1");
            System.out.println("修改简历职位请按2");
            System.out.println("查询简历职位请按3");
            System.out.println("退出请按4");
            int number=input.nextInt();
            switch (number){
                case 0: add();break;
                case 1: delete();break;
                case 2: updata();break;
                case 3: search();break;
                case 4: end();break;
                default:System.out.println("您的输入超出目前服务范围！");
            }
        }
        input.close();
        formatter.close();
    }
    void add(){
        System.out.println("请输入姓名，学号");
        String name=input.next();
        String id=input.next();
        Resume onepeople=new Resume(name,id);
        resumes.add(onepeople);
    }
    void delete(){
        System.out.println("欢迎进入浦发银行招聘网站注销界面！");
        System.out.println("请输入要删除的id");
        String delid=input.next();
        for(int i=0;i<resumes.size();i++) {
            if(resumes.get(i).getId().equals(delid)){
                resumes.remove(i);
                formatter.format("客户%s的简历已经注销\n",delid);
                break;
            }
        }
    }
    void updata(){
        System.out.println("请输入您要修改的用户的ID！");
        String updid=input.next();
        int i;
        for(i=0;i<resumes.size();i++) {
            if(resumes.get(i).getId().equals(updid)) {
                System.out.println("只有姓名信息可以修改，请输入要修改的姓名！");
                String newname=input.next();
                resumes.get(i).setName(newname);
                resumes.get(i).setSchool("0");
                formatter.format("客户%s的姓名修改为%s\n", resumes.get(i).getId(), resumes.get(i).getName());
                break;
            }
        }
        if(resumes.size()==i)
            System.out.println("系统没有您想要修改的id");
    }
    void search(){
        for(int i=0;i<resumes.size();i++) {
            Resume temppeople=resumes.get(i);
            formatter.format("第%d位客户%s的id为%s,简历状态为%s\n",
                    i,resumes.get(i).getName(),resumes.get(i).getId(),resumes.get(i).getSchool());
        }
    }
    void end(){
        firstOne=false;
        System.out.println("您已退出浦发招聘网站，感谢您的下次使用");
    }
    public static void main(String[] args){
        new HR_s();
    }
}
