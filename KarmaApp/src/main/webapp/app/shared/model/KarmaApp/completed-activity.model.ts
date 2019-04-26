import { IMedia } from 'app/shared/model/KarmaApp/media.model';

export interface ICompletedActivity {
  id?: number;
  registeredUserId?: number;
  activityId?: number;
  proofs?: IMedia[];
}

export class CompletedActivity implements ICompletedActivity {
  constructor(public id?: number, public registeredUserId?: number, public activityId?: number, public proofs?: IMedia[]) {}
}
