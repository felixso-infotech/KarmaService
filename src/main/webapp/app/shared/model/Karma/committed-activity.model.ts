import { Moment } from 'moment';
import { IMedia } from 'app/shared/model/Karma/media.model';
import { ICommittedActivity } from 'app/shared/model/Karma/committed-activity.model';

export const enum Status {
  TODO = 'TODO',
  INPROGRESS = 'INPROGRESS',
  DONE = 'DONE'
}

export interface ICommittedActivity {
  id?: number;
  description?: string;
  status?: Status;
  createdDate?: Moment;
  activityId?: number;
  activityProofs?: IMedia[];
  committedActivities?: ICommittedActivity[];
  registeredUserId?: number;
  referenceId?: number;
}

export class CommittedActivity implements ICommittedActivity {
  constructor(
    public id?: number,
    public description?: string,
    public status?: Status,
    public createdDate?: Moment,
    public activityId?: number,
    public activityProofs?: IMedia[],
    public committedActivities?: ICommittedActivity[],
    public registeredUserId?: number,
    public referenceId?: number
  ) {}
}
