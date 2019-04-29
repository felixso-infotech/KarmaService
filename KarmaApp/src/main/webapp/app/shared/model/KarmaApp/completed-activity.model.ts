import { IMedia } from 'app/shared/model/KarmaApp/media.model';

export interface ICompletedActivity {
  id?: number;
  registeredUserId?: number;
  proofs?: IMedia[];
  activityidId?: number;
}

export class CompletedActivity implements ICompletedActivity {
  constructor(public id?: number, public registeredUserId?: number, public proofs?: IMedia[], public activityidId?: number) {}
}
