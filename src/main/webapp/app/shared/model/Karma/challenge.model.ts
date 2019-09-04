import { Moment } from 'moment';
import { ICompletedChallenge } from 'app/shared/model/Karma/completed-challenge.model';
import { IActivity } from 'app/shared/model/Karma/activity.model';

export interface IChallenge {
  id?: number;
  name?: string;
  successMessage?: string;
  createdDate?: Moment;
  completedChallenges?: ICompletedChallenge[];
  activities?: IActivity[];
}

export class Challenge implements IChallenge {
  constructor(
    public id?: number,
    public name?: string,
    public successMessage?: string,
    public createdDate?: Moment,
    public completedChallenges?: ICompletedChallenge[],
    public activities?: IActivity[]
  ) {}
}
