export class UVehicle {
  registrationNo: String;
  inspectionStatus: String;
  inspectedByUserId: number;
  inspectedOn: Date
  constructor(registrationNo: String,
    inspectionStatus: String,
    inspectedByUserId: number,
    inspectedOn: Date) {
    this.registrationNo = registrationNo;
    this.inspectionStatus = inspectionStatus;
    this.inspectedByUserId = inspectedByUserId;
    this.inspectedOn = inspectedOn;
  }

}