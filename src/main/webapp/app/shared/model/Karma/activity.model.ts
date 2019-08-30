import { Moment } from 'moment';
import { IIntroductionStory } from 'app/shared/model/Karma/introduction-story.model';
import { ICommittedActivity } from 'app/shared/model/Karma/committed-activity.model';
import { IDimension } from 'app/shared/model/Karma/dimension.model';

export const enum Type {
  SINGLE = 'SINGLE',
  TEAM = 'TEAM'
}

export const enum ProofType {
  IMAGE = 'IMAGE',
  VIDEO = 'VIDEO',
  TEXT = 'TEXT',
  PDF = 'PDF',
  PPT = 'PPT',
  DOC = 'DOC',
  XLX = 'XLX'
}

export interface IActivity {
  id?: number;
  title?: string;
  description?: string;
  successMessage?: string;
  type?: Type;
  createdDateAndTime?: Moment;
  proofType?: ProofType;
  isMultipleProofsRequired?: boolean;
  noOfPages?: number;
  stories?: IIntroductionStory[];
  committededActivities?: ICommittedActivity[];
  challengeId?: number;
  dimensions?: IDimension[];
}

export class Activity implements IActivity {
  constructor(
    public id?: number,
    public title?: string,
    public description?: string,
    public successMessage?: string,
    public type?: Type,
    public createdDateAndTime?: Moment,
    public proofType?: ProofType,
    public isMultipleProofsRequired?: boolean,
    public noOfPages?: number,
    public stories?: IIntroductionStory[],
    public committededActivities?: ICommittedActivity[],
    public challengeId?: number,
    public dimensions?: IDimension[]
  ) {
    this.isMultipleProofsRequired = this.isMultipleProofsRequired || false;
  }
}
