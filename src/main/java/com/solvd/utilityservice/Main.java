package com.solvd.utilityservice;

import com.solvd.utilityservice.organization.ControlClass;
import com.solvd.utilityservice.organization.OrgCatalog;
import com.solvd.utilityservice.organization.equipment.ConstructionMaterial;
import com.solvd.utilityservice.organization.equipment.Material;
import com.solvd.utilityservice.organization.equipment.MaterialCost;
import com.solvd.utilityservice.organization.paper.Document;
import com.solvd.utilityservice.organization.paper.ReceiptOfPayment;
import com.solvd.utilityservice.organization.service.InsideWork;
import com.solvd.utilityservice.organization.service.OutsideWork;
import com.solvd.utilityservice.organization.service.Service;
import com.solvd.utilityservice.organization.service.impl.AccountingServiceImpl;
import com.solvd.utilityservice.organization.service.impl.ServiceClassImpl;
import com.solvd.utilityservice.organization.staff.*;
import com.solvd.utilityservice.organization.structure.Organization;
import com.solvd.utilityservice.organization.structure.Position;
import com.solvd.utilityservice.organization.structure.PositionName;
import com.solvd.utilityservice.organization.structure.Profsouz;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.*;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Organization zhes = new Organization("Housing maintenance service №1");
        Service service2 = new Service("InstallationOfMeters", 15, 3, true, true);
        Service service3 = new Service("ChangeOfMeters", 11, 2, true, false);
        Set<Service> orgServices = new HashSet<>();
        orgServices.add(service2);
        orgServices.add(service3);
        zhes.setService(orgServices);

        BusinessQuestion usluga = new BusinessQuestion();
        usluga.setService(orgServices);
        usluga.print(orgServices);
        System.out.println();

        LOGGER.info("Positions in the organization:");
        Position acc = new Position(PositionName.ACCOUNTANT, 1400);
        Position rep = new Position(PositionName.REPAIRER, 1300);
        Position pl = new Position(PositionName.PLUMBER, 1200);
        Set<Position> orgPositions = new TreeSet<>();
        orgPositions.add(acc);
        orgPositions.add(rep);
        orgPositions.add(pl);
        acc.print();
        rep.print();
        pl.print();
        //LOGGER.debug(Arrays.toString(PositionName.values()));
        System.out.println();

        Employee alex = new Employee("Alexander", "Rybak", pl);
        alex.setDob(LocalDateTime.of(1996, 10, 9, 0, 0));
        alex.setExperience(6);
        Employee lena = new Employee("Elena", "Rybalka", acc);
        lena.setDob(LocalDateTime.of(1996, 10, 3, 0, 0));
        lena.setExperience(8);
        List<Employee> orgEmployees = new ArrayList<>();
        orgEmployees.add(alex);
        orgEmployees.add(lena);
        zhes.setEmployee(orgEmployees);
        AccountingServiceImpl accounting = new AccountingServiceImpl();
        accounting.setEmployees(orgEmployees);
        zhes.setAccounting(accounting);
        LOGGER.debug("Given " + alex.getLastName() + "'s work experience, the salary is " + accounting.salaryCounting(alex) + " rubles.");
        accounting.chargeBonus(alex);
        System.out.println();

        service2.doService(service2);
        service3.doService(service3, 10);
        System.out.println();

        alex.chooseBonusForEmployee(alex, 1234);
        alex.chooseBonusForEmployee(alex);
        System.out.println();

        //lesson-3
        alex.countYearsOfWork(2016);
        System.out.println();
        alex.meetClient();

        Director head1 = new Director("Mark", "Gilbert");
        head1.meetClient();
        System.out.println();

        InsideWork iw1 = new InsideWork("CleanToilets", 12, 2);
        LOGGER.debug(iw1);
        OutsideWork ow1 = new OutsideWork("PaintingWalls", 41, 15, -4);
        LOGGER.debug(ow1);
        System.out.println();
        orgServices.add(iw1);
        orgServices.add(ow1);

        Profsouz profsouz = new Profsouz("Trade-union committee", "Eugena Barskih", 14);
        profsouz.sayHB(alex);
        profsouz.isNowWorkingHours();
        LOGGER.debug("Department is working now: " + profsouz.isNowWorkingHours());
        System.out.println();

        ConstructionMaterial paint = new ConstructionMaterial("Paint", 9, 10, true);
        Material brick = new ConstructionMaterial("Brick", 2, 100, false);
        //ConstructionMaterial 1 = new ConstructionMaterial("Paint", 9, 10, true);
        LOGGER.debug(paint);
        System.out.println();
        List<Material> orgMaterials = new ArrayList<>();
        orgMaterials.add(paint);
        orgMaterials.add(brick);

        Map<Integer, Document> numberAndNameOfDocuments = new HashMap<>();
        ReceiptOfPayment rop37 = new ReceiptOfPayment(37, "Water payment №273",
                LocalDateTime.of(2021, 10, 6, 2, 10), head1);
        Document rop117 = new ReceiptOfPayment(117, "Renovation work, apartments №54",
                LocalDateTime.of(2021, 8, 6, 2, 10), head1);
        numberAndNameOfDocuments.put(rop37.getNumber(), rop37);
        numberAndNameOfDocuments.put(rop117.getNumber(), rop117);
        System.out.println();

        Staff max = new Employee("Max", "Shtein", rep);
        ControlClass.speakWithClients(max);

        Staff stef = new Director("Stephan", "Hoffman");
        ControlClass.speakWithClients(stef);
        List<Director> directors = new ArrayList<>();
        directors.add(head1);
        directors.add((Director) stef);
        zhes.setDirector(directors);
        System.out.println();

        //lesson-4
        ServiceClassImpl serviceClassImpl = new ServiceClassImpl();
        LOGGER.info("The 1st interface:");
        System.out.println();
        serviceClassImpl.meetClient(head1);
        System.out.println();

        LOGGER.info("The second interface:");
        System.out.println();
        serviceClassImpl.getSalary(alex);
        System.out.println();

        LOGGER.info("The third interface:");
        System.out.println();
        serviceClassImpl.isDepartmentWork(profsouz);
        System.out.println();

        LOGGER.info("The 4th interface:");
        System.out.println();
        AccountingServiceImpl accountingServiceImpl = new AccountingServiceImpl();
        accountingServiceImpl.chargeBonus(alex);
        System.out.println();

        LOGGER.info("The 5th interface:");
        System.out.println();
        serviceClassImpl.utilizeStuff(paint);
        System.out.println();

        //lesson-5
        Employee peter = new Employee("Peter", "Stone", rep);
        try {
            peter.setYearOfEmployment(2005);
        } catch (InvalidYearOfEmploymentException e) {
            LOGGER.error("Invalid data. " + e.getMessage());
        } finally {
            LOGGER.info("The end of operation");
        }
        System.out.println();
        orgEmployees.add(peter);
        orgEmployees.add((Employee) max);

        /*Check of invalid data:
        acc.setSalary(-2000);
        peter.setLastName(""); */

        try (InternetConnection connection = new InternetConnection()) {
            LOGGER.info("The try-block");
        }
        System.out.println();

        //lesson-6
        LOGGER.info("The 1st collection:");
        System.out.println();
        LOGGER.debug(orgEmployees);
        System.out.println();
        LOGGER.info("The second collection:");
        System.out.println();
        LOGGER.debug(directors);
        System.out.println();
        LOGGER.info("The third collection:");
        System.out.println();
        LOGGER.debug(orgServices);
        System.out.println();
        LOGGER.info("The 4th collection: Organization positions from the lowest salary: ");
        System.out.println();
        LOGGER.debug(orgPositions);
        System.out.println();
        LOGGER.info("The 5th collection:");
        System.out.println();
        LOGGER.debug(orgMaterials);
        System.out.println();
        LOGGER.info("HashMap:");
        System.out.println();
        LOGGER.debug(numberAndNameOfDocuments);
        System.out.println();

        OrgCatalog<Position> catalog1 = new OrgCatalog<>();
        catalog1.printCatalog(orgPositions);
        System.out.println();

        MaterialCost<? extends Material> materialCost = new MaterialCost<>(brick);
        LOGGER.debug("Cost of chosen item = " + materialCost.countCost() + " rubles.");
        System.out.println();

        AccountRegistration<String> acc1 = new AccountRegistration("123qwerty123");
        String acc1Pass = acc1.getPassword();
        LOGGER.debug("Account was registered. Don't forget your password: " + acc1Pass);

        AccountRegistration<Integer> acc2 = new AccountRegistration(123);
        Integer acc2Pass = acc2.getPassword();
        LOGGER.debug("Account was registered. Don't forget your password: " + acc2Pass);

    }
}