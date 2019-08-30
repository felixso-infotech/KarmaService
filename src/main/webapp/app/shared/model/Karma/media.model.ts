export interface IMedia {
  id?: number;
  fileName?: string;
  fileContentType?: string;
  file?: any;
  committedActivityId?: number;
  completedChallengeId?: number;
}

export class Media implements IMedia {
  constructor(
    public id?: number,
    public fileName?: string,
    public fileContentType?: string,
    public file?: any,
    public committedActivityId?: number,
    public completedChallengeId?: number
  ) {}
}
