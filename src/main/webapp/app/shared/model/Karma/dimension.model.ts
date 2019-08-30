import { IActivity } from 'app/shared/model/Karma/activity.model';

export interface IDimension {
  id?: number;
  name?: string;
  activities?: IActivity[];
}

export class Dimension implements IDimension {
  constructor(public id?: number, public name?: string, public activities?: IActivity[]) {}
}
