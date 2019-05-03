import { ICompletedActivity } from 'app/shared/model/KarmaApp/completed-activity.model';

export interface IRegisteredUser {
  id?: number;
  firstName?: string;
  lastName?: string;
  email?: string;
  phoneNumber?: number;
  noOfCoins?: number;
  noOfBronzeMedals?: number;
  noOfSilverMedals?: number;
  noOfGoldMedals?: number;
  profilePicId?: number;
  completedActivities?: ICompletedActivity[];
}

export class RegisteredUser implements IRegisteredUser {
  constructor(
    public id?: number,
    public firstName?: string,
    public lastName?: string,
    public email?: string,
    public phoneNumber?: number,
    public noOfCoins?: number,
    public noOfBronzeMedals?: number,
    public noOfSilverMedals?: number,
    public noOfGoldMedals?: number,
    public profilePicId?: number,
    public completedActivities?: ICompletedActivity[]
  ) {}
}
