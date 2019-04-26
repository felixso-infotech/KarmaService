export interface IMedia {
  id?: number;
  fileName?: string;
  fileContentType?: string;
  file?: any;
  activityId?: number;
  completedActivityId?: number;
}

export class Media implements IMedia {
  constructor(
    public id?: number,
    public fileName?: string,
    public fileContentType?: string,
    public file?: any,
    public activityId?: number,
    public completedActivityId?: number
  ) {}
}
