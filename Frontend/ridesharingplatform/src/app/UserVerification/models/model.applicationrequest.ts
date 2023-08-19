export class ApplicationRequest{
    userId:number;
    username:string;
    officialEmail:string;
    phoneNumber:string;
    designation:string;
    roleId:number;
    employeeId:string;
    aadharNumber:string;
    companyId: number;
    licenseNo: string ="";
    expirationDate: Date | null;
    rta: string;
    allowedVehicles:string;
    applicationStatus:string;

    constructor(userId:number,
        username:string,
        officialEmail:string,
        phoneNumber:string,
        designation:string,
        roleId:number,
        employeeId:string,
        aadharNumber:string,
        companyId: number,
        licenseNo: string,
        expirationDate: Date,
        rta: string,
        allowedVehicles:string){
            this.userId = userId;
    this.username=username;
    this.officialEmail=officialEmail;
    this.phoneNumber=phoneNumber;
    this.designation=designation;
    this.roleId=roleId;
    this.employeeId=employeeId;
    this.aadharNumber=aadharNumber;
    this.companyId =companyId;
    this.licenseNo=licenseNo;
    this.expirationDate=expirationDate;
    this.rta=rta;
    this.allowedVehicles=allowedVehicles;
        }
}