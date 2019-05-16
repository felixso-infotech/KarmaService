import { IMedia } from 'app/shared/model/KarmaApp/media.model';
import { ICompletedActivity } from 'app/shared/model/KarmaApp/completed-activity.model';

export interface IActivity {
  id?: number;
  title?: string;
  description?: string;
  successMessage?: string;
  url?: string;
  instructionVideoId?: number;
  files?: IMedia[];
  completedActivities?: ICompletedActivity[];
}

export class Activity implements IActivity {
  constructor(
    public id?: number,
    public title?: string,
    public description?: string,
    public successMessage?: string,
    public url?: string,
    public instructionVideoId?: number,
    public files?: IMedia[],
    public completedActivities?: ICompletedActivity[]
  ) {}
}