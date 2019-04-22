import {User} from './User';
import {Room} from './Room';

export class Meeting {
  id: number;
  dateOfTheBeginning: string;
  dateOfEnd: string;
  theme: string;
  room: Room;
  timeOfNotification: number;
  members: User[];
}
