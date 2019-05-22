export class Meeting {
  id: string;
  creator: string;
  dateOfTheBeginning: string;
  dateOfEnd: string;
  theme: string;
  idRoom: string;
  timeOfNotification: number;
  membersId: string[];
  constructor() {
    this.membersId = [];
  }
}
