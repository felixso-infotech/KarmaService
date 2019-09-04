import { Moment } from 'moment';
import { IMedia } from 'app/shared/model/Karma/media.model';

export interface ICompletedChallenge {
  id?: number;
  description?: string;
  createdDate?: Moment;
  challengeId?: number;
  proofs?: IMedia[];
  userId?: number;
}

export class CompletedChallenge implements ICompletedChallenge {
  constructor(
    public id?: number,
    public description?: string,
    public createdDate?: Moment,
    public challengeId?: number,
    public proofs?: IMedia[],
    public userId?: number
  ) {}
}
