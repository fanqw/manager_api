package com.fqw.manager.vo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.fqw.manager.dao.ResidentInfoMapper;

public class Test {
	
	public static void main(String[] args) {
		
		Resident resident = new Resident();
		Date date = randomDate("1925-01-01","2018-04-01");  
		resident.setBirthday(new java.sql.Date(date.getTime()));
		String birthday = new SimpleDateFormat("yyyyMMdd").format(date);
		resident.setUser_id(autoUserID(birthday));
		Calendar calendar = Calendar.getInstance();
		int index = calendar.get(Calendar.SECOND); 
		resident.setGender(index%2);
		resident.setName(autoName(index%2));
//        System.out.println(autoUserID(birthday));  
//        System.out.println(autoName(1));
		System.out.println(resident.toString());
//		residentInfoMapper.insertResident(resident);
	}

	 /** 
     * 获取随机日期 
     * @param beginDate 起始日期，格式为：yyyy-MM-dd 
     * @param endDate 结束日期，格式为：yyyy-MM-dd 
     * @return 
     */  
    public static Date randomDate(String beginDate,String endDate){  
        try {  
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
            Date start = format.parse(beginDate);  
            Date end = format.parse(endDate);  
              
            if(start.getTime() >= end.getTime()){  
                return null;  
            }  
              
            long date = random(start.getTime(),end.getTime());  
              
            return new Date(date);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
      
    public static long random(long begin,long end){  
        long rtn = begin + (long)(Math.random() * (end - begin));  
        if(rtn == begin || rtn == end){  
            return random(begin,end);  
        }  
        return rtn;  
    }  
	
	
	public static String autoUserID(String s1) {
		Random random1 = new Random();
		int num1 = random1.nextInt(999);
//		System.out.println(num1);
		String s2 = "";
		if(num1 <10) {
			s2 = "00"+num1;
		}else if(num1 < 100 ) {
			s2 = "0"+num1;
		}else {
			s2 = num1+"";
		}
//		System.out.println(s2);
		String[] s3 = {"0","1","2","3","4","5","6","7","8","9","x"};
		Random random2 = new Random();
		int num2 = random2.nextInt(10);
		return "410329"+s1+s2+s3[num2];
	}
	
	public static String autoName(int num) {
		String[] manArr = {"伟","刚","勇","毅","俊","峰","强","军","平","东","文","辉","力","明","永","健","世","广","义","兴","良","海","山","仁","波","宁","贵","福","生","龙","元","全","国","胜","学","祥","才","发利","清","飞","彬","富","顺","信","子","杰","涛","昌","成","康","星","光","天","达","安","岩林","有","坚","和","彪","博","诚","先","敬","震","振","壮","会","思","豪","心","邦","承","乐绍","功","松","厚","庆","磊","民","友","裕","河","哲","江","超","浩","亮","政","谦","亨","固轮","翰","朗","伯","宏","言","若","鸣","朋","斌","梁","栋","维","启","克","伦","翔","旭","皓晨","辰","士","建","家","致","炎","德","行","时","泰","盛","雄","琛","钧","冠","策","腾","弘志","武","中","榕","奇","鹏","楠","泽","风","茂","航"};
		String[] womanArr= {"筠","柔","竹","霭","凝","晓","欢","霄","枫","芸","菲","寒","伊","亚","宜","可","姬","舒","影","荔","枝","思","丽","秀","娟","英","华","慧","巧","美","娜","静","淑","惠","珠","翠","雅","芝","玉","萍","红","娥","玲","芬","芳","燕","彩","春","菊","勤","珍","贞","莉","兰","凤","洁","梅","琳","素","云","莲","真","环","雪","荣","爱","妹","霞","香","月","莺","媛","艳","瑞","凡","佳","嘉","琼","桂","娣","叶","璧","璐","娅","琦","晶","妍","茜","秋","珊","莎","锦","黛","青","倩","婷","姣","婉","娴","瑾","颖","露","瑶","怡","婵","雁","蓓","纨","仪","荷","丹","蓉","眉","君","琴","蕊","薇","菁","梦","岚","苑","婕","馨","瑗","琰","韵","融","园","艺","咏","卿","聪","澜","纯","毓","悦","昭","冰","爽","琬","茗","羽","希","宁","欣","飘","育","滢","馥","楠"};
		String[] lastname = {"范","张","刘","魏","程","沈","周","袁","万","武","赵","孙","李","王","杨","钱","冯","韩"};
		int len1 = manArr.length;
		int len2 = womanArr.length;
		int len3 = lastname.length;
		System.out.println(len1+" "+len2+" "+len3);
		String name ="";
		
		if(num%2 == 0) {//男
			name = "范"+manArr[num%len1]+manArr[num*2%len1];
		}else {//女
			name = lastname[num%len3]+womanArr[num*2%len2]+womanArr[num*3%len2];
		}
		return name;
	}
}
