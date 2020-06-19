package com.example.analysit.ParseData;

import com.example.analysit.JsonModel.CompanyCountVacancy;
import com.example.analysit.JsonModel.CompanyVacancyPositionCount;
import com.example.analysit.JsonModel.LanguagePosition;
import com.example.analysit.JsonModel.LanguageStatistics.LanguageCount;
import com.example.analysit.JsonModel.LanguageStatistics.LanguageStatistics;
import com.example.analysit.JsonModel.PositionCount;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class VacancyData implements Serializable {
    ArrayList<Vacancy> vacancies = new ArrayList<>();

    public ArrayList<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(ArrayList<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public void addList(ArrayList<Vacancy> list){
        this.vacancies.addAll(list);
        this.changeIndex();
    }
///// некоректно працює
//    public  void  addToList(ArrayList<Vacancy> list){
//        if (vacancies.size()!=0) {
//            for (int i = 0; i < list.size(); i++) {
//                Vacancy vacancy = list.get(i);
//                for (Vacancy vac : vacancies) {
//                    if (vac.sheckVacancy(vacancy)) {
//                        this.vacancies.add(vacancy);
//                    }
//                }
//            }
//        }else {
//            vacancies.add(list.get(0));
//            for (int i = 1; i < list.size(); i++) {
//                Vacancy vacancy = list.get(i);
//                for (int j = 0;j<vacancies.size();j++) {
//                    Vacancy vac = vacancies.get(j);
//                    if (vac.sheckVacancy(vacancy)) {
//                        this.vacancies.add(vacancy);
//                    }
//                }
//            }
//
//        }
////        vacancies.addAll(list);
//        changeIndex();
//        System.out.println("ADDEd");
//    }

    public ArrayList<PopularLang> selectPopularlanguage(){
        ArrayList<PopularLang> popularLangs = new ArrayList<>();
//        ArrayList<Vacancy> java  = (ArrayList<Vacancy>) this.getVacanciesByLanguage("java");
//        int javal  = this.getVacanciesByLanguage("Java").size();
//        int ch =  this.getVacanciesByLanguage("C#").size();
//        int cpp = this.getVacanciesByLanguage("C++").size();
//        int php = this.getVacanciesByLanguage("PHP").size();
//        int js = this.getVacanciesByLanguage("Java script").size();
//        int python =  this.getVacanciesByLanguage("Python").size();
//        int ruby =  this.getVacanciesByLanguage("Ruby").size();
//        int android =  this.getVacanciesByLanguage("Android").size();
//        int data = this.getVacanciesByLanguage("Data science").size();
//        int goland = this.getVacanciesByLanguage("Goland").size();
//        int ios  = this.getVacanciesByLanguage("IOS").size();
//        int qa  = this.getVacanciesByLanguage("QA").size();
//        int pm  = this.getVacanciesByLanguage("Project manager").size();


        popularLangs.add(new PopularLang("Java",this.getVacanciesByLanguage("Java").size()));
        popularLangs.add(new PopularLang(".NET",this.getVacanciesByLanguage(".NET").size()));
        popularLangs.add(new PopularLang("C++",this.getVacanciesByLanguage("C++").size()));
        popularLangs.add(new PopularLang("PHP",this.getVacanciesByLanguage("PHP").size()));
        popularLangs.add(new PopularLang("Java script",this.getVacanciesByLanguage("Java script").size()));
        popularLangs.add(new PopularLang("Python",this.getVacanciesByLanguage("Python").size()));
        popularLangs.add(new PopularLang("Ruby",this.getVacanciesByLanguage("Ruby").size()));
        popularLangs.add(new PopularLang("Android",this.getVacanciesByLanguage("Android").size()));
        popularLangs.add(new PopularLang("Data science",this.getVacanciesByLanguage("Data science").size()));
        popularLangs.add(new PopularLang("Goland",this.getVacanciesByLanguage("Goland").size()));
        popularLangs.add(new PopularLang("IOS",this.getVacanciesByLanguage("IOS").size()));
        popularLangs.add(new PopularLang("QA",this.getVacanciesByLanguage("QA").size()));
        popularLangs.add(new PopularLang("Project manager",this.getVacanciesByLanguage("Project manager").size()));
        return popularLangs;

    }
//    public List<Vacancy> getJavaVacancies(){
//
//        List<Vacancy> list = vacancies.stream()
//                .filter(x->"java".equals(x.getLanguage())).collect(Collectors.toList());
//        return list;
//
//    }
    public List<Vacancy> getVacanciesByLanguage(String lang){

        List<Vacancy> list = vacancies.stream()
                .filter(x->lang.equals(x.getLanguage())).collect(Collectors.toList());
        return list;
    }
    public List<Vacancy> getVacanciesByLanguage(String lang,ArrayList<Vacancy> vacancyList){

        List<Vacancy> list = vacancyList.stream()
                .filter(x->lang.equals(x.getLanguage())).collect(Collectors.toList());
        return list;
    }

    public ArrayList<String> getAllCompany(){
        // список компаній
        ArrayList<String> companyList = new ArrayList<>();
        for (Vacancy v: vacancies) {
            if (uniqueCompany(companyList,v.getCompany())){
                companyList.add(v.getCompany());
            }
        }
        return companyList;
    }



    public List<Vacancy> getVacancyByCompany(String company){
        // вакансії певної компанії
        List<Vacancy> list = vacancies.stream()
                .filter(x->company.equals(x.getCompany())).collect(Collectors.toList());
        return list;
    }


    public ArrayList<LanguageCount> getVacancyCompanyLanguage(ArrayList<Vacancy> list){
       ArrayList<String>  lang =  this.getAllLAnguage(list);
       for (String s :lang) {
           System.out.println(s);
       }
       ArrayList<LanguageCount> languageCounts = new ArrayList<>();

       for (String str:lang){
           LanguageCount languageCount = new LanguageCount();
           languageCount.setLanguage(str);
          languageCount.setCount(this.getVacanciesByLanguage(str,list).size());
          languageCounts.add(languageCount);
       }
        System.out.println( "SIZE LIst " + languageCounts.size());
        Collections.sort(languageCounts, Collections.reverseOrder());

        System.out.println("Language count");
       for (LanguageCount lc:languageCounts){
           System.out.println(lc);

       }
       ArrayList<LanguageCount> counts = new ArrayList<>();


        if (languageCounts.size()<2){
///// якщо кількість вак менша
           counts.addAll(languageCounts);
           counts.add(new LanguageCount("Інші",0));
        }else {
            int sum=0;
            int others =0;
            for (int i=0;i<languageCounts.size();i++){
                if (i<=1){
                    sum = sum+languageCounts.get(i).getCount();
                }else {
                    others = others+languageCounts.get(i).getCount();
                }
            }

//        System.out.println( "SIZE" + languageCounts.size());
            counts.addAll(languageCounts.subList(0,2));
            counts.add(new LanguageCount("інші ", others));
        }


       return counts;

    }
    public ArrayList<CompanyCountVacancy> getCountVacancyByCompany(){
        // компанія і кількість вакансій
        ArrayList<CompanyCountVacancy> countVacancies  = new ArrayList<>();
        ArrayList<String> companyList = this.getAllCompany();
        for (int i=0;i<companyList.size();i++) {
            countVacancies.add(new CompanyCountVacancy(companyList.get(i),this.getVacancyByCompany(companyList.get(i)).size()));
        }
        Collections.sort(countVacancies, Collections.reverseOrder());
return countVacancies;
    }

    // початковий метод
    public ArrayList<CompanyCountVacancy> getTopCompanies(){
        ArrayList<CompanyCountVacancy> countVacancies = new ArrayList<>();
        countVacancies.addAll(this.getCountVacancyByCompany().subList(0,10));
        ArrayList<CompanyCountVacancy> list = new ArrayList<>();
        for (CompanyCountVacancy ccv:countVacancies){
            CompanyCountVacancy companyCountVacancy = new CompanyCountVacancy();
            companyCountVacancy.setCompany(ccv.getCompany());
            companyCountVacancy.setCount(ccv.getCount());
            ArrayList<Vacancy> vacancies =(ArrayList<Vacancy>) this.getVacancyByCompany(ccv.getCompany());
            ArrayList<LanguageCount> languageCounts = this.getVacancyCompanyLanguage(vacancies);
            companyCountVacancy.setLanguageCounts(languageCounts);
            list.add(companyCountVacancy);
        }
        return list;
    }

    public ArrayList<String> getAllPosition(){
        // всі посади /рівні
        ArrayList<String> positions = new ArrayList<>();
        for(Vacancy v:vacancies){
            if (uniquePosition(positions,v.getPosition())){
                positions.add(v.getPosition());
            }
        }
        return positions;
    }
    public ArrayList<String> getAllPosition(ArrayList<Vacancy> list){
        // всі посади /рівні
        ArrayList<String> positions = new ArrayList<>();
        for(Vacancy v:list){
            if (uniquePosition(positions,v.getPosition())){
                positions.add(v.getPosition());
            }
        }
        return positions;
    }
    public ArrayList<String> getAllLAnguage(){
        // мови
        ArrayList<String > language= new ArrayList<>();
        for (Vacancy v:vacancies){
            if (uniqueLanguage(language,v.getLanguage())){
                language.add(v.getLanguage());
//                System.out.println(v.getLanguage());
            }
        }

        return language;
    }

    public ArrayList<String> getAllLAnguage(ArrayList<Vacancy> list){
        // мови
        ArrayList<String > language= new ArrayList<>();
        for (Vacancy v:list){
            if (uniqueLanguage(language,v.getLanguage())){
                language.add(v.getLanguage());
            }
        }
        return language;
    }





    public ArrayList<PositionCount> getPositionCount(ArrayList<Vacancy> list, ArrayList<String> positionList){
        // список кількості по позиції
        ArrayList<PositionCount> positionCounts = new ArrayList<>();
        for (int i=0;i<positionList.size();i++){
            PositionCount count = new PositionCount(positionList.get(i),selectPosition(list,positionList.get(i)).size());
            positionCounts.add(count);
        }
        return positionCounts;
    }





    public ArrayList<CompanyVacancyPositionCount> getVacancyByCompanyLanguagePosition(){
        ///доробити
        ArrayList<CompanyVacancyPositionCount> companyVacancyPositionCounts = new ArrayList<>();


        ArrayList<String> namecompany = getAllCompany();
        ArrayList<String> nameLanguage = new ArrayList<>();
        ArrayList<String> namePosition = new ArrayList<>();
        ArrayList<Vacancy> vacByCompanyName = new ArrayList<>();
        ArrayList<Vacancy> vacByCompanyLanguage = new ArrayList<>();
        ArrayList<Vacancy> vacByCompanyLanguahePosition = new ArrayList<>();

//        ArrayList<Vacancy> vacByLanguageCompany = new ArrayList<>();



        LanguagePosition languagePosition = new LanguagePosition();
        PositionCount count = new PositionCount();

        for (int i=0;i<namecompany.size();i++){
            vacByCompanyName = selectVacancyCompany(vacancies,namecompany.get(i));
            CompanyVacancyPositionCount companyVacancyPositionCount = new CompanyVacancyPositionCount();

            companyVacancyPositionCount.setCompany(namecompany.get(i));
            for (int j=0;j<vacByCompanyName.size();j++){
                 nameLanguage = getAllLAnguage(vacByCompanyName);// мови для пототчної контори


                for (int z = 0;z<nameLanguage.size();z++){
                    vacByCompanyLanguage = selectVacancyLanguage(vacByCompanyName,nameLanguage.get(z));



                    languagePosition.setLanguage(nameLanguage.get(z));


                    for (int x=0;x<vacByCompanyLanguage.size();x++){
                        namePosition = getAllPosition(vacByCompanyLanguage);

                        count = new PositionCount();

                        for (int c=0;c<namePosition.size();c++){
                            vacByCompanyLanguahePosition = selectPosition(vacByCompanyLanguage,namePosition.get(c));
                            count.setPosition(namePosition.get(c));
                            count.setCount(vacByCompanyLanguage.size());

                            languagePosition.addPositionCount(count);
                            count = new PositionCount();
                        }
                    }
//                    languagePosition.setLanguage(nameLanguage.get(z));
                    companyVacancyPositionCount.addLanhuahePosition(languagePosition);
//                    languagePosition.addPositionCount(count);
                }

            }

//            companyVacancyPositionCount.addLanhuahePosition(languagePosition);
            companyVacancyPositionCounts.add(companyVacancyPositionCount);
        }
        return companyVacancyPositionCounts;
    }


    private ArrayList<Vacancy> selectPosition(ArrayList<Vacancy> data, String position){
        // посада
        ArrayList<Vacancy> list =(ArrayList<Vacancy>) data.stream()
                .filter(x->x.getPosition().equals(position))
                .collect(Collectors.toList());
        return list;
    }
    private ArrayList<Vacancy> selectVacancyLanguage(ArrayList<Vacancy> data, String language){
        //мова
        ArrayList<Vacancy> list =(ArrayList<Vacancy>) data.stream()
                .filter(x->x.getLanguage().equals(language))
                .collect(Collectors.toList());
        return list;
    }
    private ArrayList<Vacancy> selectVacancyCompany(ArrayList<Vacancy> data, String company){
        // компанія
        ArrayList<Vacancy> list =(ArrayList<Vacancy>) data.stream()
                .filter(x->x.getCompany().equals(company))
                .collect(Collectors.toList());
        return list;
    }


    private boolean uniqueLanguage(ArrayList<String> lang,String l){
        for (String s :lang){
            if (s.equals(l)){
                return false;
            }
        }
        return true;
    }
    private boolean uniquePosition(ArrayList<String>position,String p){
        // унікальні осади
        for (String s :position ) {
            if (s.equals(p)){
                return false;
            }
        }
        return true;
    }

//    private PositionCount setPositionCount(String pos, int cout)

    private boolean uniqueCompany(ArrayList<String> list, String company){
        //унікальність компанії
        for (String s :list){
            if (s.equals(company)){
                return false;
            }
        }
        return true;
    }
    private void changeIndex(){
        ArrayList<Vacancy> list = new ArrayList<>();
        for (int i=0;i<vacancies.size();i++){
            Vacancy vacancy = vacancies.get(i);
            vacancy.setId(i);
            list.add(vacancy);
        }
        this.vacancies = list;
    }
    public  Vacancy getByID(int id){
        Vacancy vac = new Vacancy();
        for (int i=0;i<vacancies.size();i++){
            vac = vacancies.get(i);
            if (vac.getId()==id){
                return vac;
            }
        }
    return  new Vacancy();
    }
    public ArrayList<Vacancy> getBySite(String site){
        ArrayList<Vacancy> list = new ArrayList<>();
        for (Vacancy v:vacancies){
            if (v.getSite().equals(site)){
                list.add(v);
            }
        }
        return list;
    }


    public LanguageStatistics getStatictickByAllLanguage(){// вивід статистики мов за поточний період
//        getVacanciesByLanguage
        LanguageStatistics statistics = new LanguageStatistics();
        ArrayList<String> lang = this.getAllLAnguage();
        for (String s :lang){
            statistics.add(new LanguageCount(s,this.getVacanciesByLanguage(s).size()));
        }
        return statistics;
    }

    public CompanyVacancyPositionCount getDetailInfoAboutCompany(String company){
//        company = "Very Good Security";
        System.out.println(company);
        ArrayList<Vacancy> list = this.selectVacancyCompany(this.vacancies, company);
        ArrayList<String> listLanguages = getAllLAnguage(list);
        CompanyVacancyPositionCount companyVacancyPositionCount = new CompanyVacancyPositionCount();
        companyVacancyPositionCount.setCompany(company);
        for (String s :listLanguages){
            System.out.println("LANG+ "+s);
            ArrayList<Vacancy> listVacancyLang = this.selectVacancyLanguage(list,s);
            ArrayList<String> positionList = getAllPosition(listVacancyLang);

//            ArrayList<LanguagePosition> languagePositions = new ArrayList<>();
            LanguagePosition languagePosition = new LanguagePosition();
            languagePosition.setLanguage(s);

            for (String p:positionList){
                ArrayList<Vacancy> listVacancyPosition = selectPosition(listVacancyLang,p);
                PositionCount positionCount = new PositionCount();
                positionCount.setPosition(p);
                positionCount.setCount(listVacancyPosition.size());
                System.out.println(positionCount);

                languagePosition.addPositionCount(positionCount);
            }
            companyVacancyPositionCount.addLanhuahePosition(languagePosition);

        }
        return companyVacancyPositionCount;
    }

    public  ArrayList<CompanyVacancyPositionCount> getDetailInfoAboutAllCompany(){
        ArrayList<String> companyList = this.getAllCompany();
        ArrayList<CompanyVacancyPositionCount> companyVacancyPositionCountsList = new ArrayList<>();
        for (String s:companyList){
            CompanyVacancyPositionCount companyVacancyPositionCount = this.getDetailInfoAboutCompany(s);
            companyVacancyPositionCountsList.add(companyVacancyPositionCount);
        }

        return companyVacancyPositionCountsList;
    }
    //

    private boolean containsSpace(String str){
        //false
        int index =  str.indexOf(" ");
        if(index==-1){
            return false;
        }else {
            return true;
        }
    }
    private boolean containsAt(String str){
        // true
        return str.contains(" at ");
    }

    private ArrayList<String> getExistCompanyNameFromDou(){
        ArrayList<String> companyList = new ArrayList<>();
        for (Vacancy vacancy:this.vacancies){
            if (vacancy.getSite().equals("dou")){
                String company = vacancy.getCompany();
                if(companyList.size()>0){
                    if(uniqueCompany(companyList,company)==true){
                        companyList.add(company);
                    }
                }

            }
        }
        return companyList;
    }
    public void updateNameCompany(){
        System.out.println("UPDATE COMPANY");
        ArrayList<Vacancy> vacancies1 = new ArrayList<>();
        for (Vacancy vacancy:vacancies){
            if (this.ifVacancyFromDou(vacancy)==false){
                String comp = vacancy.getCompany();
               String comp1 =  this.selectCompanyNameFromString(comp);
                vacancy.setCompany(comp1);
                System.out.println(comp1);
                vacancies1.add(vacancy);
            }else {
                vacancies1.add(vacancy);
            }
        }
        this.vacancies = new ArrayList<>();
        this.vacancies.addAll(vacancies1);
        System.out.println("NEW VAC");
        for (Vacancy v:vacancies){
            System.out.println(v);
        }
    }
    private String selectCompanyNameFromString(String string){
        if (containsSpace(string)==true){
            // отже є пробіли і декілька слів тому перевірка по вже існуючих компаніях
            ArrayList<String> companyList = this.getExistCompanyNameFromDou();
            for (String s :companyList) {
                if (string.contains(s)) {
                    // знайдено в стрічні існуючу назву тому ми її повертаємо
                    return s;
                }
            }
            // коли цикл завершився то збігів не знайдено тому перевірка на at
            if (this.containsAt(string)){
                // так тоді пошук фрагменту після at
            String[] strings  = string.split("\\s");// розділить слова про пробілу
                for (int i =0;i<strings.length;i++){
                    if (strings[i].equals("at")){
                        // коли true повертаєм наступний елемент
                        return strings[i+1];//
                    }
//                    else{
//                        // варіант коли стрічка містить at в кінці тоді повертаєм початкову стрічку
//                        return string;
//                    }
                }
            }else {
                //алгоритм підійшов до кінця отже назва не повторилась і має пробіли і не містить at тому
                return string;
            }



        }else {
            // отже 1 слово тому це назва
            return string;
        }
        System.out.println("ERORRRR selectCompanyNameFromString");
        return string;
    }
    private boolean ifVacancyFromDou(Vacancy vacancy){
        if (vacancy.getSite().equals("dou")){
            return true;
        }else {
            return false;
        }
    }




}
