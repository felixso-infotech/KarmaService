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
  createdDateAndTime?: Moment;
  activityId?: number;
  activityProofs?: IMedia[];
  committedActivities?: ICommittedActivity[];
  userId?: number;
  referenceIdId?: number;
}

export class CommittedActivity implements ICommittedActivity {
  constructor(
    public id?: number,
    public description?: string,
    public status?: Status,
    public createdDateAndTime?: Moment,
    public activityId?: number,
    public activityProofs?: IMedia[],
    public committedActivities?: ICommittedActivity[],
    public userId?: number,
    public referenceIdId?: number
  ) {}
}
