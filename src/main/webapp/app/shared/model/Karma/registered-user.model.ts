import { Moment } from 'moment';
import { ICommittedActivity } from 'app/shared/model/Karma/committed-activity.model';
import { ICompletedChallenge } from 'app/shared/model/Karma/completed-challenge.model';

export interface IRegisteredUser {
  id?: number;
  firstName?: string;
  lastName?: string;
  email?: string;
  createdDate?: Moment;
  phoneNumber?: string;
  userId?: string;
  profilePictureContentType?: string;
  profilePicture?: any;
  coverPhotoContentType?: string;
  coverPhoto?: any;
  committedActivities?: ICommittedActivity[];
  completedChallenges?: ICompletedChallenge[];
}

export class RegisteredUser implements IRegisteredUser {
  constructor(
    public id?: number,
    public firstName?: string,
    public lastName?: string,
    public email?: string,
    public createdDate?: Moment,
    public phoneNumber?: string,
    public userId?: string,
    public profilePictureContentType?: string,
    public profilePicture?: any,
    public coverPhotoContentType?: string,
    public coverPhoto?: any,
    public committedActivities?: ICommittedActivity[],
    public completedChallenges?: ICompletedChallenge[]
  ) {}
}
