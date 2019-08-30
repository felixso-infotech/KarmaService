export interface IIntroductionStory {
  id?: number;
  story?: string;
  imageContentType?: string;
  image?: any;
  activityId?: number;
}

export class IntroductionStory implements IIntroductionStory {
  constructor(
    public id?: number,
    public story?: string,
    public imageContentType?: string,
    public image?: any,
    public activityId?: number
  ) {}
}
