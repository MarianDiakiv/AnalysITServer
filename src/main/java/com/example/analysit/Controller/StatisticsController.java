package com.example.analysit.Controller;

        import com.example.analysit.JsonModel.CompanyCountVacancy;
        import com.example.analysit.JsonModel.CompanyVacancyPositionCount;
        import com.example.analysit.JsonModel.LanguageStatistics.LanguageCount;
        import com.example.analysit.JsonModel.LanguageStatistics.LanguageStatistics;
        import com.example.analysit.Service.StatisticsService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.ArrayList;

@RestController
public class StatisticsController {

    @Autowired private StatisticsService statisticsService;
    @GetMapping("/statictics/nowselected")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<LanguageCount> getgetStatisticsByNowTime(){
        return statisticsService.getStatisticsByNowTime().getCountArrayList();
    }
    @GetMapping("/statistics/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public  ArrayList<LanguageStatistics> getAllStatistic(){
        return statisticsService.getStatisticsAll().getCountArrayList();
    }
    @GetMapping("/statistics/top/company")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<CompanyCountVacancy> getTopCompany(){
        return this.statisticsService.getCountVacancyByCompany();
    }

    @GetMapping("/statistics/CompanyStatistics")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<CompanyVacancyPositionCount> getCompanyVacancyPosCount(){
        return this.statisticsService.getCompanyVacancyPositionCount();
    }
//    @GetMapping("/statistics/CompanyStatisticsOne/{company}")
//    @CrossOrigin(origins = "http://localhost:4200")
//    public CompanyVacancyPositionCount getCompanyVacancyPosCountOne(@PathVariable("company") String company){
//
////        return this.statisticsService.getCompanyVacancyPositionCount().get(0);
////        return  this.statisticsService.getInfoAboutCompany("Very Good Security");
//        System.out.println("csdchlsdvbjkdbvkjdbvjfbj");
//        return  this.statisticsService.getInfoAboutCompany(company);
//    }
    @GetMapping("/statistics/CompanyStatisticsOne/{company}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<CompanyVacancyPositionCount> getCompanyVacancyPosCountOne(@PathVariable("company") String company){

        System.out.println("csdchlsdvbjkdbvkjdbvjfbj");
        ArrayList<CompanyVacancyPositionCount> list = new ArrayList<>();
        list.add(this.statisticsService.getInfoAboutCompany(company));
        return  list;
    }
    @GetMapping("/statistics/CompanyStatisticsAll")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<CompanyVacancyPositionCount> getCompanyVacancyPosCountAll(){

//        return this.statisticsService.getCompanyVacancyPositionCount().get(0);
        return  this.statisticsService.getInfoAboutAllCompany();
    }
    @GetMapping("/statistics/usersSubscribes")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<LanguageCount> getUserSubscribesStatics(){
       LanguageStatistics statistics  = this.statisticsService.getUserInterestings();
        ArrayList<LanguageCount> list = statistics.getCountArrayList();
        return list;
    }

}
